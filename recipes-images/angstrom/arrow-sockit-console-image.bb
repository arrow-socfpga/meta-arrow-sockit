require recipes-images/angstrom/console-image.bb

IMAGE_INSTALL += " \
	altera-gsrd-apps \
	altera-gsrd-initscripts \
	altera-gsrd-pio-interrupt \
	arrow-sockit-leds
	arrow-sockit-lighttpd-conf \
	arrow-sockit-usb-gadget \
	arrow-sockit-webcontent \
	arrow-sockit-x11vnc-init \
	bash \
	ethtool \
	gcc \
	gdb \
	gdbserver \
	gnuplot \
	i2c-tools \
	iperf \
	iw \
	kernel-dev \
	kernel-image \
	kernel-modules \
	lighttpd \
	lighttpd-module-cgi \
	ne10 \
	net-tools \
	nfs-utils-client \
	packagegroup-sdk-target \
	tar \
	usbutils \
	vim \
	vim-vimrc \
"
export IMAGE_BASENAME = "arrow-sockit-console-image"

#overload timestamp function in image.bbclass

rootfs_update_timestamp () {
        date -u +%4Y%2m%2d%2H%2M -d "+1 day">${IMAGE_ROOTFS}/etc/timestamp
}

EXPORT_FUNCTIONS rootfs_update_timestamp