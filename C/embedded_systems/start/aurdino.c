void setup() {
    pinMode(13, OUTPUT);
}
void loop() {
    digitWrite(13, HIGH),
    delay(1000);
    digitWrite(13, LOW);
    delay(1000);
}