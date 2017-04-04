#!/bin/sh

modprobe g_multi file=/usr/share/arrow-sockit-usb-gadget/fat_image.img

sleep 5

#rm /var/lib/misc/udhcpd.leases
/sbin/ifconfig usb0 hw ether 00:01:02:50:c4:17
/sbin/ifconfig usb0 192.168.5.1 netmask 255.255.255.0
/usr/sbin/udhcpd -fS -I 192.168.5.1 /etc/udhcpd.conf
