require arrow-sockit-console-image.bb

IMAGE_INSTALL += " \
	angstrom-clearlooks-theme-enable \
	angstrom-gnome-icon-theme-enable \
	angstrom-x11vnc-xinit \
	epiphany \
	gedit \
	gtk-engine-clearlooks \
	gtk-theme-clearlooks \
	packagegroup-core-x11-xserver \
	packagegroup-gnome-fonts \
	packagegroup-gnome-xserver-base \
	packagegroup-xfce-base \
	synergy \
	x11vnc \
	xserver-nodm-init \
	xserver-xorg-xvfb \
	xterm \
"

export IMAGE_BASENAME = "arrow-sockit-xfce-image"
