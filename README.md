masktextfield
=============

Mask TextField for JavaFX

By David Augusto

davidaug23.7@gmail.com

www.david.blog.br



  Class MaskTextField
  
  
  Use:
  
  1) Create a instace of the class(Or put a <MaskTextField>, same as <TextField> into the FXML)
  
  2) Use the function setMask(String mask) to create a mask
  
  3) With the characters above, set the mask [Ex: objectmask.setMask("XXXXXX")]
  
  
  Characters of the mask:
  
  
   \* = Accept any character
   
   A = Only Alphanumerics
   
   N = Only Numbers
   
   L = Only Letters
   
   U = Only Uppercase Letters
   
   l = Only Lowercase Letters
   
   S = Any character, except Space
   
   P = Only Letters and Points
   
   M = Letters, Numbers and Points
   

  Examples above
  
  
  
  ==================== EXAMPLES =====================
  
  String mask = "N!.N!"
  
  Accept only numbers separated by a point
  Ex:
  1.1 , 111.111 , 123124.1 12312.00
  
  String mask = "NN.NN"
  
  Accept only two numbers before and after a point
  Ex:
  11.11 , 33.33, 13.30
  
  String mask = "U"
  
  Accept any character and an Uppercase letter
  Ex:
  /L , L , [space]L
  
  String mask = "Ul!"
  
  Accept only an Uppercase letter, and one or a sequence of lowercase letters
  Ex: 
  David, Augusto
  
  String mask = "M!@M!.P!"
  
  An email
  Ex:
  davidaug23.7@gmail.com , themail@maildomain.co.uk
