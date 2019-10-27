require arrow-sockit-console-image.bb

IMAGE_INSTALL += " \
	epiphany \
	evince \
	gedit \
	gtk-engine-clearlooks \
	gtk-theme-clearlooks \
	packagegroup-core-x11-xserver \
	packagegroup-gnome-fonts \
	packagegroup-gnome-xserver-base \
	packagegroup-xfce-base \
	x11vnc \
	xserver-nodm-init \
	xserver-xorg-xvfb \
	xterm \
"

export IMAGE_BASENAME = "arrow-sockit-xfce-image"
