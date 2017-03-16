SUMMARY = "Arrow SoCKit lighttpd webserver customization"
DESCRIPTION = "Arrow SoCKit lighttpd configuration customization to enable cgi, set 404 page, and change serverroot"
AUTHOR = "Dan Negvesky <dnegvesky@arrow.com>"
SECTION = "arrow-sockit"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM="file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

inherit allarch
ALLOW_EMPTY_${PN} = "1"

PR = "r1"
PV = "1.0${PR}"

## Post process the lighttpd.conf file to enable cgi module, sets home page and update 404 page
#pkg_postinst_${PN}() {
##!/bin/sh
#sed -ir 's:#\(.*mod_cgi\"\,\):\1:' $D/etc/lighttpd.conf
#sed -i '/server.document-root/c server.document-root        = "/usr/share/arrow-sockit-webcontent"' $D/etc/lighttpd.conf
#sed -ir 's:\(index-file.names *\=\).*\(,\):\1 ("index.html"\2:' $D/etc/lighttpd.conf
#echo 'server.error-handler-404   = "/not_found.html"' >> $D/etc/lighttpd.conf
#echo 'cgi.assign = ( ".sh"  => "/bin/sh" )' >> $D/etc/lighttpd.conf
#}

# Sticking with this configuration for now until SoCKit webpage is updated and CGI no longer needed

# Post process the lighttpd.conf file to enable cgi module, sets home page and update 404 page
pkg_postinst_${PN}() {
#!/bin/sh
sed -ir 's:#\(.*mod_cgi\"\,\):\1:' $D/etc/lighttpd.conf
sed -ir 's:\(index-file.names *\=\).*\(,\):\1 ("\/cgi-bin\/index.sh"\2:' $D/etc/lighttpd.conf
echo 'server.error-handler-404   = "/not_found.html"' >> $D/etc/lighttpd.conf
echo 'cgi.assign = ( ".sh"  => "/bin/sh" )' >> $D/etc/lighttpd.conf
}

RDEPENDS_{PN} = "lighttpd-module-cgi"
