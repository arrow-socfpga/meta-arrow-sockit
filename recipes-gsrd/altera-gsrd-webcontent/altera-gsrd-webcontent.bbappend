DESCRIPTION = "Arrow SoCKit GSRD web content customization"
AUTHOR = "Dan Negvesky <dnegvesky@arrow.com>"

# replace existing index.sh with sockit version
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# add a sockit customized flash file
SRC_URI += "file://sockit-board-flash.swf"

do_install_append() {

        install -m 0755 ${WORKDIR}/sockit-board-flash.swf ${D}/www/pages/
}
