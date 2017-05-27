public int validate(String s){
  int pass=0;
  boolean digit=false, boolean up=false, boolean low=false, boolean special=false;
  String sChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";
  for(int i=0;i<s.length();i++){
    if(Character.isDigit(s.charAt(i)))
      digit=true;
    if(Character.isUpperCase(s.charAt(i)))
      up=true;
    if(Character.isLowerCase(s.charAt(i)))
      low=true;
    if(sChars.contains(s.charAt(i)))
      special=true;
  }
  if(special)
    pass++;
  if(low&&up)
    pass++;
  if(digit)
    pass++;
  if(s!="password")
    pass++;
  if(s.length()<8)
    pass++;
  return pass;
}
