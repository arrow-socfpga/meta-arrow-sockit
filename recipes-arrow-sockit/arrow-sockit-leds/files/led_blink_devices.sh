clear
echo "Blink the LEDs"

echo "1" > '/sys/class/leds/fpga_led0/brightness'
echo "1" > '/sys/class/leds/fpga_led1/brightness'
echo "1" > '/sys/class/leds/fpga_led2/brightness'
echo "1" > '/sys/class/leds/fpga_led3/brightness'
echo "1" > '/sys/class/leds/hps_led0/brightness'
echo "1" > '/sys/class/leds/hps_led1/brightness'
echo "1" > '/sys/class/leds/hps_led2/brightness'
echo "1" > '/sys/class/leds/hps_led3/brightness'
sleep 1

echo "1" > '/sys/class/leds/fpga_led0/brightness'
sleep 1
echo "0" > '/sys/class/leds/fpga_led0/brightness'
echo "1" > '/sys/class/leds/fpga_led1/brightness'
sleep 1
echo "0" > '/sys/class/leds/fpga_led1/brightness'
echo "1" > '/sys/class/leds/fpga_led2/brightness'
sleep 1
echo "0" > '/sys/class/leds/fpga_led2/brightness'
echo "1" > '/sys/class/leds/fpga_led3/brightness'
sleep 1
echo "0" > '/sys/class/leds/fpga_led3/brightness'
echo "1" > '/sys/class/leds/hps_led3/brightness'
sleep 1
echo "0" > '/sys/class/leds/hps_led3/brightness'
echo "1" > '/sys/class/leds/hps_led2/brightness'
sleep 1
echo "0" > '/sys/class/leds/hps_led2/brightness'
echo "1" > '/sys/class/leds/hps_led1/brightness'
sleep 1
echo "0" > '/sys/class/leds/hps_led1/brightness'
echo "1" > '/sys/class/leds/hps_led0/brightness'
sleep 1
echo "0" > '/sys/class/leds/hps_led0/brightness'
sleep 1
echo "1" > '/sys/class/leds/fpga_led0/brightness'
echo "1" > '/sys/class/leds/fpga_led1/brightness'
echo "1" > '/sys/class/leds/fpga_led2/brightness'
echo "1" > '/sys/class/leds/fpga_led3/brightness'
echo "1" > '/sys/class/leds/hps_led0/brightness'
echo "1" > '/sys/class/leds/hps_led1/brightness'
echo "1" > '/sys/class/leds/hps_led2/brightness'
echo "1" > '/sys/class/leds/hps_led3/brightness'



