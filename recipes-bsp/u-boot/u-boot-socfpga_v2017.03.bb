require recipes-bsp/u-boot/u-boot-socfpga-common.inc                                               
require recipes-bsp/u-boot/u-boot-socfpga-env.inc                                                  
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc 

PR = "r15"

FILESEXTRAPATHS_prepend := "${THISDIR}/files/v2017.03:"

DEPENDS += "u-boot-mkimage-native"

#SRCREV = "b24cf8540a85a9bf97975aadd6a7542f166c78a3"
SRCREV = "8537ddd769f460d7fb7a62a3dcc9669049702e51"

SRCREV_FORMAT = "arrow-sockit-ghrd"
SRCREV_arrow-sockit-ghrd = "${AUTOREV}"

SRC_URI_append = "\
	file://0001-arm-socfpga-Move-CONFIG_EXTRA_ENV_SETTINGS-to-common.patch \
	file://0002-arm-socfpga-update-terasic-sockit-to-support-distro-.patch \
	file://0006-arm-socfpga-fix-issue-with-warm-reset-when-CSEL-is-0.patch \
	git://github.com/dnegvesky/arrow-sockit-ghrd.git;destsuffix=arrow-sockit-ghrd;name=arrow-sockit-ghrd;branch=sockit-ghrd-1080p-16.1 \
	"

# Update project specific files in uboot 
do_configure_append_arrow-sockit() {
	${WORKDIR}/git/arch/arm/mach-socfpga/qts-filter.sh \
	    cyclone5 \
	    ${WORKDIR}/arrow-sockit-ghrd/ \
	    ${WORKDIR}/arrow-sockit-ghrd/software/preloader/ \
	    ${WORKDIR}/git//board/terasic/sockit/qts/
}

DEPENDS += "dtc-native"                                                         
DEPENDS += "u-boot-mkimage-native"
