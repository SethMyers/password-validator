public int validate(String s){
  int pass=0;
  if(s!="password")
    pass++;
  if(s.length()<8)
    pass++;
  return pass;
}
