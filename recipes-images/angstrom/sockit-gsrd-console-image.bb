require recipes-images/angstrom/console-image.bb

IMAGE_INSTALL += "altera-gsrd-apps \
                  altera-gsrd-initscripts \
                  altera-gsrd-pio-interrupt \
                  altera-gsrd-webcontent \
                  altera-lighttpd-conf \                  
                  lighttpd \
                  lighttpd-module-cgi \
                  gator \
                  arrow-sockit-custom"

export IMAGE_BASENAME = "sockit-gsrd-console-image"

