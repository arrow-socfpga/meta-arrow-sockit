DESCRIPTION = "Altera GSRD pio interrupt module."
AUTHOR = "Tien Hock Loh <thloh@altera.com>"
SECTION = "gsrd"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PR = "r0"
PV = "0.1"

REFDES_REPO ?= "git://github.com/altera-opensource/linux-refdesigns.git"
REFDES_PROT ?= "http"
SRCREV = "504ab64ac09b332ad9af4d46e65be4e93d4d74c3"

SRC_URI = "${REFDES_REPO};protocol=${REFDES_PROT} "

S = "${WORKDIR}/git/pio-interrupt"
