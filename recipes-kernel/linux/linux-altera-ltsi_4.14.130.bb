DESCRIPTION = "Arrow SoCKit linux customization - LED scripts"
AUTHOR = "Dan Negvesky <dnegvesky@arrow.com>"
SECTION = "arrow-sockit"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM="file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

PR = "r0"
FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append_arrow-sockit += " \
				file://socfpga_cyclone5_arrow_sockit.dts \
				file://socfpga-4.14-ltsi/cfg/altvipfb.cfg \
				file://socfpga-4.14-ltsi/cfg/block.cfg \
				file://socfpga-4.14-ltsi/cfg/cma.cfg \
				file://socfpga-4.14-ltsi/cfg/configfs.cfg \
				file://socfpga-4.14-ltsi/cfg/gpio-keys.cfg \
				file://socfpga-4.14-ltsi/cfg/led-triggers.cfg \
				file://socfpga-4.14-ltsi/cfg/usb-gadget.cfg \
				"

do_compile_prepend () {                                                            
        cp ${THISDIR}/config/socfpga_cyclone5_arrow_sockit.dts ${S}/arch/${ARCH}/boot/dts                          
}  
