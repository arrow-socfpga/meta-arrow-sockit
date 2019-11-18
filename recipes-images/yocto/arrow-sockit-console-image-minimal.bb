inherit core-image

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_INSTALL += " \
	arrow-sockit-fpga-init \
	arrow-sockit-leds \
	arrow-sockit-linux-firmware \
"

export IMAGE_BASENAME = "arrow-sockit-console-image-minimal"

IMAGE_FEATURES += "package-management"

#overload timestamp function in image.bbclass

rootfs_update_timestamp () {
        date -u +%4Y%2m%2d%2H%2M -d "+1 day">${IMAGE_ROOTFS}/etc/timestamp
}

#inherit update-rc.d
#INITSCRIPT_PACKAGES = "dhcp-server"
#INITSCRIPT_NAME = "dhcp-server"
#INITSCRIPT_PARAMS = "start 50 S . stop 50 0 6 1 ."

EXPORT_FUNCTIONS rootfs_update_timestamp
#	altera-gsrd-apps \
#	altera-gsrd-initscripts \
#	altera-gsrd-pio-interrupt \
#	arrow-sockit-lighttpd-conf \
#	arrow-sockit-usb-gadget \
#	arrow-sockit-webcontent \
#	arrow-sockit-x11vnc-init \
#	arrow-sockit-xfce-init \
#	bash \
#	ethtool \
#	gcc \
#	gdb \
#	gdbserver \
#	i2c-tools \
#	iw \
#	kernel-dev \
#	kernel-image \
#	kernel-modules \
#
#	lighttpd \
#	lighttpd-module-cgi \
#	net-tools \
#	nfs-utils-client \
#	python \
#	tar \
#	usbutils \
#	vim \
#	vim-vimrc \
#	gnuplot \
#	iperf \
#	packagegroup-sdk-target \
