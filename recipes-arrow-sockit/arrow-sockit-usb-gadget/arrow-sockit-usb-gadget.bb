SUMMARY = "Arrow SoCKit Units to initialize USB gadgets"
DESCRIPTION = "Arrow SoCKit scripts to start USB gadget for USB mass storage, Ethernet, and serial interfaces"
AUTHOR = "Dan Negvesky <dnegvesky@arrow.com>"
SECTION = "arrow-sockit"

PR = "r1"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

inherit systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

PACKAGE_ARCH = "${MACHINE_ARCH}"
SRCREV = "${AUTOREV}"
PV = "1.0${PR}+git${SRCPV}"

SRC_URI = "file://arrow-sockit-gadget-init.service \
           file://arrow-sockit-gadget-init.sh \
           file://udhcpd.conf \
	   git://github.com/arrow-socfpga/sockit-drivers.git \
          "

do_install() {
	install -d ${D}${base_libdir}/systemd/system
	install -m 0644 ${WORKDIR}/*.service ${D}${base_libdir}/systemd/system

	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/*.conf ${D}${sysconfdir}

	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/*.sh ${D}${bindir}

	install -d ${D}${sysconfdir}/systemd/system/getty.target.wants
	( cd ${D}${sysconfdir}/systemd/system/getty.target.wants && ln -s /lib/systemd/system/serial-getty@.service serial-getty@ttyGS0.service )

	install -d ${D}${datadir}/${PN}
	tar -xzvf ${WORKDIR}/git/fat_image.img.tgz -C ${D}${datadir}/${PN}
}

PACKAGES =+ "${PN}-network ${PN}-udhcpd"

ALLOW_EMPTY_${PN} = "1"

FILES_${PN} = "${base_libdir}/systemd/system/arrow-sockit-gadget-init.service \
               ${sysconfdir}/systemd/ \
               ${datadir}/${PN}/ \
               ${datadir}/${PN}/fat_image.img \
              "

FILES_${PN}-network = "${base_libdir}/systemd/system/network-gadget-init.service \
                       ${bindir}/arrow-sockit-gadget-init.sh \
		       ${datadir}/${PN}"

FILES_${PN}-udhcpd = "${sysconfdir}/udhcpd.conf"

RRECOMMENDS_${PN} = "${PN}-network ${PN}-udhcpd"
RREPLACES_${PN} = "${PN}-storage"


NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "arrow-sockit-gadget-init.service"
