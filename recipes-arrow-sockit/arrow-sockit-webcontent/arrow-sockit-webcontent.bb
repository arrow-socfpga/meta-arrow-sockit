DESCRIPTION = "Arrow SoCKit Board Web Content"
AUTHOR = "Dan Negvesky <dnegvesky@arrow.com>"
SECTION = "arrow-sockit"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM="file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

PR = "r0"
SRCREV = "${AUTOREV}"
PV = "1.0${PR}+git${SRCPV}"

#SRC_URI = "git://github.com/arrow-socfpga/arrow-sockit-webcontent.git"
SRC_URI = "git://github.com/dnegvesky/arrow-sockit-webcontent.git"
S = "${WORKDIR}/git"

#Use this when SoCKit webpages are updated if we stop using CGI index.sh script
#do_install() {
#	install -d ${D}${datadir}/${PN}
#	cp -a ${S}/* ${D}${datadir}/${PN}
#}

#FILES_${PN} += "${datadir}/${PN}"
FILES_${PN} = "/www/pages/*"

inherit allarch

#S = "${WORKDIR}"

do_install() {
	install -d ${D}/www/pages/cgi-bin
	install -m 0755 AC_RunActiveContent.js ${D}/www/pages/
	install -m 0755 altera-logo.gif ${D}/www/pages/
	install -m 0755 blinkled.gif ${D}/www/pages/
	install -m 0755 board-flash.jpg ${D}/www/pages/
	install -m 0755 board.jpg ${D}/www/pages/
	install -m 0755 favicon.ico ${D}/www/pages/
	install -m 0755 helper_script.js ${D}/www/pages/
	install -m 0755 index.sh ${D}/www/pages/cgi-bin/
	install -m 0755 not_found.html ${D}/www/pages/
	install -m 0755 offled.jpg ${D}/www/pages/
	install -m 0755 onled.jpg ${D}/www/pages/
	install -m 0755 progress.js ${D}/www/pages/
	install -m 0755 runningled.gif ${D}/www/pages/
	install -m 0755 sockit-board-flash.swf ${D}/www/pages/
	install -m 0755 style.css ${D}/www/pages/
	install -m 0755 validation_script.js ${D}/www/pages/
}
