PR = "r5"

FILESEXTRAPATHS_prepend := "${THISDIR}/files/v2016.11:"

DEPENDS += "u-boot-mkimage-native"

SRCREV_FORMAT = "arrow-sockit"
SRCREV_arrow-sockit = "${AUTOREV}"

SRC_URI_append = "\
	file://arrow-sockit.env \
	"

SRC_URI_append_arrow-sockit = " \
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
