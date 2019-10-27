inherit core-image

IMAGE_INSTALL += " \
	altera-gsrd-apps \
	altera-gsrd-initscripts \
	altera-gsrd-pio-interrupt \
	arrow-sockit-fpga-init \
	arrow-sockit-leds \
	arrow-sockit-lighttpd-conf \
	arrow-sockit-linux-firmware \
	arrow-sockit-usb-gadget \
	arrow-sockit-webcontent \
	arrow-sockit-x11vnc-init \
	arrow-sockit-xfce-init \
	bash \
	ethtool \
	gcc \
	gdb \
	gdbserver \
	i2c-tools \
	iw \
	kernel-dev \
	kernel-image \
	kernel-modules \
	lighttpd \
	lighttpd-module-cgi \
	net-tools \
	nfs-utils-client \
	python \
	tar \
	usbutils \
	vim \
	vim-vimrc \
"

export IMAGE_BASENAME = "arrow-sockit-console-image"

IMAGE_FEATURES += "package-management"

#overload timestamp function in image.bbclass

rootfs_update_timestamp () {
        date -u +%4Y%2m%2d%2H%2M -d "+1 day">${IMAGE_ROOTFS}/etc/timestamp
}

EXPORT_FUNCTIONS rootfs_update_timestamp
#
#	gnuplot \
#	iperf \
#	packagegroup-sdk-target \
