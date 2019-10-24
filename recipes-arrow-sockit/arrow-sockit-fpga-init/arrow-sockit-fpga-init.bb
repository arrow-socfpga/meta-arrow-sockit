SUMMARY = "Arrow SoCKit FPGA Initialization"
DESCRIPTION = "Scripts to initialize the FPGA and its peripherals using devicetree overlays."
AUTHOR = "Dan Negvesky <dnegvesky@arrow.com>"
SECTION = "arrow-sockit"

PR = "r3"

inherit systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=b97a012949927931feb7793eee5ed924"

PACKAGE_ARCH = "${MACHINE_ARCH}"
PV = "1.0${PR}"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "file://arrow-sockit-fpga-init.service \
           file://arrow-sockit-fpga-init.sh \
          "

do_install() {
	install -d ${D}${base_libdir}/systemd/system
	install -m 0644 ${WORKDIR}/*.service ${D}${base_libdir}/systemd/system

	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/*.sh ${D}${bindir}
}

ALLOW_EMPTY_${PN} = "1"

FILES_${PN}-network = "${base_libdir}/systemd/system/arrow-sockit-fpga-init.service \
                       ${bindir}/arrow-sockit-fpga-init.sh"


NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "arrow-sockit-fpga-init.service"
