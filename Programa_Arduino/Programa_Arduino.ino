// Incluímos la librería para poder controlar el servo
#include <Servo.h>
const int ocupado=11;
const int libre=12;
 
// Declaramos la variable para controlar el servo
Servo servoMotor;
Servo servoMotor2;
int pos = 90;
void setup() {
  // Iniciamos el monitor serie para mostrar el resultado
  Serial.begin(9600);
 
  // Iniciamos el servo para que empiece a trabajar con el pin 9
  servoMotor.attach(9);
  servoMotor2.attach(10);
  //led
  pinMode(ocupado,OUTPUT);
  pinMode(libre,OUTPUT);
}
 
void loop() {

  if(Serial.available()> 0){
    int input = Serial.read();
    if(input == '1'){
          delay(2000);
          servoMotor.write(20);
          Serial.println("delay(2000);");
          Serial.println("servoMotor.write(20);");    
      }
      if(input == '2'){
         delay(2000);
         servoMotor.write(55);
         Serial.println("delay(2000);");
         Serial.println("servoMotor.write(55);");
      }
      if(input == '3'){
         delay(2000);
         servoMotor.write(135);
         Serial.println("delay(2000);");
         Serial.println("servoMotor.write(135);");

      }
      if(input == '4'){
         delay(2000);
         servoMotor.write(177);
         Serial.println("delay(2000);");
         Serial.println("servoMotor.write(177);");
      }
      if(input == '5'){
         delay(2000);
         servoMotor.write(90);
         Serial.println("delay(2000);");
         Serial.println("servoMotor.write(90);");
      }
      if(input == 'o'){
         digitalWrite(ocupado,HIGH);
         digitalWrite(libre,LOW);
         Serial.println("digitalWrite(ocupado,HIGH);");
         Serial.println("digitalWrite(libre,LOW);");
      }
      if(input == 'l'){
         digitalWrite(ocupado,LOW);
         digitalWrite(libre,HIGH);
         Serial.println("digitalWrite(ocupado,LOW);");
         Serial.println("digitalWrite(libre,HIGH);");
      }

      if(input == 'a'){
        
         delay(3000);
         
         servoMotor.write(90);
         
          for (pos = 90; pos <= 180; pos += 1) 
           {
              servoMotor2.write(pos);              
              delay(7);                       
           }
  
         delay(3000);
         
         for (pos = 180; pos >= 90; pos -= 1) 
           {
              servoMotor2.write(pos);              
              delay(7);                       
           }
         delay(500);
         servoMotor.write(20);
         delay(500);
          for (pos = 90; pos <= 180; pos += 1) 
           {
               servoMotor2.write(pos);              
              delay(7);                       
           }
         delay(3000);
         for (pos = 180; pos >= 90; pos -= 1) {servoMotor2.write(pos);              
              delay(7);                       
           }
         Serial.println("delay(3000);");
         Serial.println("servoMotor.write(90);");
         Serial.println("delay(5000);");
         Serial.println("servoMotor.write(20);");
      }
      if(input == 'b'){
                  delay(3000);
         
         servoMotor.write(90);
         
          for (pos = 90; pos <= 180; pos += 1) 
           {
              servoMotor2.write(pos);              
              delay(7);                       
           }
  
         delay(3000);
         
         for (pos = 180; pos >= 90; pos -= 1) 
           {
              servoMotor2.write(pos);              
              delay(7);                       
           }
         delay(500);
         servoMotor.write(55);
         delay(500);
          for (pos = 90; pos <= 180; pos += 1) 
           {
               servoMotor2.write(pos);              
              delay(7);                       
           }
         delay(3000);
         for (pos = 180; pos >= 90; pos -= 1) {servoMotor2.write(pos);              
              delay(7);                       
           }
         Serial.println("delay(3000);");
         Serial.println("servoMotor.write(90);");
         Serial.println("delay(5000);");
         Serial.println("servoMotor.write(55);");
      }
      if(input == 'c'){
                  delay(3000);
         
         servoMotor.write(90);
         
          for (pos = 90; pos <= 180; pos += 1) 
           {
              servoMotor2.write(pos);              
              delay(7);                       
           }
  
         delay(3000);
         
         for (pos = 180; pos >= 90; pos -= 1) 
           {
              servoMotor2.write(pos);              
              delay(7);                       
           }
         delay(500);
         servoMotor.write(135);
         delay(500);
          for (pos = 90; pos <= 180; pos += 1) 
           {
               servoMotor2.write(pos);              
              delay(7);                       
           }
         delay(3000);
         for (pos = 180; pos >= 90; pos -= 1) {servoMotor2.write(pos);              
              delay(7);                       
           }
         Serial.println("delay(3000);");
         Serial.println("servoMotor.write(90);");
         Serial.println("delay(5000);");
         Serial.println("servoMotor.write(135);");
      }
      if(input == 'd'){
                  delay(3000);
         
         servoMotor.write(90);
         
          for (pos = 90; pos <= 180; pos += 1) 
           {
              servoMotor2.write(pos);              
              delay(7);                       
           }
  
         delay(3000);
         
         for (pos = 180; pos >= 90; pos -= 1) 
           {
              servoMotor2.write(pos);              
              delay(7);                       
           }
         delay(500);
         servoMotor.write(170);
         delay(500);
          for (pos = 90; pos <= 180; pos += 1) 
           {
               servoMotor2.write(pos);              
              delay(7);                       
           }
         delay(3000);
         for (pos = 180; pos >= 90; pos -= 1) {servoMotor2.write(pos);              
              delay(7);                       
           }
         Serial.println("delay(3000);");
         Serial.println("servoMotor.write(90);");
         Serial.println("delay(5000);");
         Serial.println("servoMotor.write(170);");

      }
      if(input == 'r'){
          delay(5000);
          servoMotor.write(90);
          Serial.println("delay(5000);");
          Serial.println("servoMotor.write(90);");
      }
      if(input == 'w'){
          delay(4000);  
          Serial.println("delay(4000);");
      }
      if(input == 'x'){
     
          for (pos = 90; pos <= 180; pos += 1) 
           {
               servoMotor2.write(pos);              
              delay(15);                       
           }
          servoMotor2.write(180);
        
      }
      if(input == 'y'){
          for (pos = 180; pos >= 90; pos -= 1) 
           {
              servoMotor2.write(pos);              
              delay(15);                       
           }
          servoMotor2.write(90);
        
      }
if(input == 'h'){
         
         delay(4000);
         for (pos = 180; pos >= 90; pos -= 1) 
           {
              servoMotor2.write(pos);              
              delay(15);                       
           }
          servoMotor.write(20);
          delay(500);
             for (pos = 90; pos <= 180; pos += 1) 
           {
               servoMotor2.write(pos);              
              delay(15);                       
           }
            delay(3000);
            for (pos = 180; pos >= 90; pos -= 1) 
           {
              servoMotor2.write(pos);              
              delay(15);                       
           }
           servoMotor.write(90);
           delay(500);
          for (pos = 90; pos <= 180; pos += 1) 
           {
               servoMotor2.write(pos);              
              delay(15);                       
           }

         Serial.println("delay(3000);");
         Serial.println("servoMotor.write(90);");
         Serial.println("delay(5000);");
         Serial.println("servoMotor.write(55);");
      }
      if(input == 'j'){
     
        delay(4000);
         for (pos = 180; pos >= 90; pos -= 1) 
           {
              servoMotor2.write(pos);              
              delay(15);                       
           }
          servoMotor.write(55);
          delay(500);
             for (pos = 90; pos <= 180; pos += 1) 
           {
               servoMotor2.write(pos);              
              delay(15);                       
           }
            delay(3000);
            for (pos = 180; pos >= 90; pos -= 1) 
           {
              servoMotor2.write(pos);              
              delay(15);                       
           }
           servoMotor.write(90);
           delay(500);
          for (pos = 90; pos <= 180; pos += 1) 
           {
               servoMotor2.write(pos);              
              delay(15);                       
           }

         Serial.println("delay(3000);");
         Serial.println("servoMotor.write(90);");
         Serial.println("delay(5000);");
         Serial.println("servoMotor.write(55);");
      }
      if(input == 'k'){
       
         delay(4000);
         for (pos = 180; pos >= 90; pos -= 1) 
           {
              servoMotor2.write(pos);              
              delay(15);                       
           }
          servoMotor.write(135);
          delay(500);
             for (pos = 90; pos <= 180; pos += 1) 
           {
               servoMotor2.write(pos);              
              delay(15);                       
           }
            delay(3000);
            for (pos = 180; pos >= 90; pos -= 1) 
           {
              servoMotor2.write(pos);              
              delay(15);                       
           }
           servoMotor.write(90);
           delay(500);
          for (pos = 90; pos <= 180; pos += 1) 
           {
               servoMotor2.write(pos);              
              delay(15);                       
           }

         Serial.println("delay(3000);");
         Serial.println("servoMotor.write(90);");
         Serial.println("delay(5000);");
         Serial.println("servoMotor.write(55);");
      }
      if(input == 'm'){
      
        delay(4000);
         for (pos = 180; pos >= 90; pos -= 1) 
           {
              servoMotor2.write(pos);              
              delay(15);                       
           }
          servoMotor.write(170);
          delay(500);
             for (pos = 90; pos <= 180; pos += 1) 
           {
               servoMotor2.write(pos);              
              delay(15);                       
           }
            delay(3000);
            for (pos = 180; pos >= 90; pos -= 1) 
           {
              servoMotor2.write(pos);              
              delay(15);                       
           }
           servoMotor.write(90);
           delay(500);
          for (pos = 90; pos <= 180; pos += 1) 
           {
               servoMotor2.write(pos);              
              delay(15);                       
           }

         Serial.println("delay(3000);");
         Serial.println("servoMotor.write(90);");
         Serial.println("delay(5000);");
         Serial.println("servoMotor.write(55);");
      }

    }
 
}
