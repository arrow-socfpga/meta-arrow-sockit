SUMMARY = "Firmware for the Arrow SoCKit FPGA"
LICENSE = "MIT"
#LIC_FILES_CHKSUM = "file://${WORKDIR}/hardware/LICENSE;md5=d252b8b27e3e6ea89c9c6912b3c4373d"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit deploy

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRCREV_FORMAT = "hardware"

#SRCREV = "da2c7d8a35c3823f0851df0c6f3b560a3ffade10"
SRCREV_hardware = "${AUTOREV}"

PV="${PN}+git${SRCPV}"

SRC_URI += " \
	git://github.com/dnegvesky/arrow-sockit-ghrd.git;destsuffix=hardware;name=hardware;protocol=https;branch=sockit-ghrd-1080p-16.1 \
"

do_install () {
        cd ${WORKDIR}/hardware
	install -d ${D}${base_libdir}/firmware
        install -m 0644 output_files/soc_system.rbf ${D}${base_libdir}/firmware
        install -m 0644 devicetrees/${MACHINE}.dtbo ${D}${base_libdir}/firmware
}

do_deploy () {
        cd ${WORKDIR}/hardware
	install -d ${DEPLOYDIR}
	install -m 0644 output_files/soc_system.rbf ${DEPLOYDIR}
}

addtask deploy after do_install

FILES_${PN} = "${base_libdir}/firmware"
