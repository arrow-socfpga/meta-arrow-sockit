DESCRIPTION = "Arrow SoCKit customization - LED scripts"
AUTHOR = "Dan Negvesky <dnegvesky@arrow.com>"
SECTION = "arrow-sockit"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM="file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI = "file://clear_leds.sh \
           file://init_leds.sh \
           file://led_blink \
           file://led_blink_devices.sh"

# suppress split_and_strip_files since we don't need .debug info for led_blink binary copied below
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

# avoid QA error by skipping QA test for ldflags for prebuilt led_blink binary 
INSANE_SKIP_${PN} = "ldflags"

do_install() {
    install -d ${D}/home/root
    install -m 0755 ${WORKDIR}/clear_leds.sh ${D}/home/root
    install -m 0755 ${WORKDIR}/init_leds.sh ${D}/home/root
    install -m 0755 ${WORKDIR}/led_blink ${D}/home/root
    install -m 0755 ${WORKDIR}/led_blink_devices.sh ${D}/home/root
}

FILES_${PN} += "/home/root"