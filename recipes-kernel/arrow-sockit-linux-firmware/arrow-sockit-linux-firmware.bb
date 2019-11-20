SUMMARY = "Firmware for the Arrow SoCKit FPGA"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit deploy

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRCREV_FORMAT = "hardware"

#SRCREV = "da2c7d8a35c3823f0851df0c6f3b560a3ffade10"
SRCREV_hardware = "${AUTOREV}"

PV="${PN}+git${SRCPV}"

SRC_URI += " \
	git://github.com/arrow-socfpga/arrow-sockit-ghrd.git;destsuffix=hardware;name=hardware;protocol=https;branch=sockit-ghrd-19.1 \
"

do_install () {
        cd ${WORKDIR}/hardware
	install -d ${D}${base_libdir}/firmware
        install -m 0644 output_files/sockit_ghrd.rbf ${D}${base_libdir}/firmware
        install -m 0644 devicetrees/sockit-ghrd.dtbo ${D}${base_libdir}/firmware
}

do_deploy () {
        cd ${WORKDIR}/hardware
	install -d ${DEPLOYDIR}
	install -m 0644 output_files/sockit_ghrd.rbf ${DEPLOYDIR}
}

addtask deploy after do_install

FILES_${PN} = "${base_libdir}/firmware"
