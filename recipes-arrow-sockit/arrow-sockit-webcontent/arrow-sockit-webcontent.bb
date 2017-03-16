DESCRIPTION = "Arrow SoCKit Board Web Content"
AUTHOR = "Dan Negvesky <dnegvesky@arrow.com>"
SECTION = "arrow-sockit"

LICENSE = "MIT & LGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a8f924340e3ce1ff14c0f9f53b9a6da4"

PR = "r0"
SRCREV = "${AUTOREV}"
#when PV is set to include SRCPV, this results in a variable expansion error, see here:
#http://lists.openembedded.org/pipermail/openembedded-core/2012-December/072511.html
PV = "1.0${PR}+git${SRCPV}"
#PV = "1.0"

#SRC_URI = "git://github.com/arrow-socfpga/arrow-sockit-webcontent.git"
#SRC_URI = "git://github.com/dnegvesky/arrow-sockit-webcontent.git"
#S = "${WORKDIR}/git"

#Use this when SoCKit webpages are updated if we stop using CGI index.sh script
#do_install() {
#	install -d ${D}${datadir}/${PN}
#	cp -a ${S}/* ${D}${datadir}/${PN}
#}

FILES_${PN} += "${datadir}/${PN}"

inherit allarch

SRC_URI = "file://AC_RunActiveContent.js \
	   file://altera-logo.gif \
	   file://arria10-board-flash.swf \
	   file://arriav-board-flash.swf \
	   file://blinkled.gif \
	   file://board-flash.jpg \
	   file://board.jpg \
	   file://cyclonev-board-flash.swf \
	   file://sockit-board-flash.swf \
	   file://favicon.ico \
	   file://helper_script.js \
	   file://not_found.html \
	   file://offled.jpg \
	   file://onled.jpg \
	   file://progress.js \
	   file://runningled.gif \
	   file://style.css \
	   file://validation_script.js \
	   file://index.sh \
	  "

S = "${WORKDIR}"

do_install() {
	install -d ${D}/www/pages/cgi-bin
	install -d ${D}/home/root/altera
	install -m 0755 AC_RunActiveContent.js ${D}/www/pages/
	install -m 0755 altera-logo.gif ${D}/www/pages/
	install -m 0755 arriav-board-flash.swf ${D}/www/pages/
	install -m 0755 arria10-board-flash.swf ${D}/www/pages/
	install -m 0755 blinkled.gif ${D}/www/pages/
	install -m 0755 board-flash.jpg ${D}/www/pages/
	install -m 0755 board.jpg ${D}/www/pages/
	install -m 0755 cyclonev-board-flash.swf ${D}/www/pages/
	install -m 0755 sockit-board-flash.swf ${D}/www/pages/
	install -m 0755 favicon.ico ${D}/www/pages/
	install -m 0755 helper_script.js ${D}/www/pages/
	install -m 0755 not_found.html ${D}/www/pages/
	install -m 0755 offled.jpg ${D}/www/pages/
	install -m 0755 onled.jpg ${D}/www/pages/
	install -m 0755 progress.js ${D}/www/pages/
	install -m 0755 runningled.gif ${D}/www/pages/
	install -m 0755 style.css ${D}/www/pages/
	install -m 0755 validation_script.js ${D}/www/pages/
	install -m 0755 index.sh ${D}/www/pages/cgi-bin
}

FILES_${PN} = "/www/pages/*"