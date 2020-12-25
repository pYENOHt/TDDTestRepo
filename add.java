class Test{

  int Add(String numbers){
    int sum = 0;
   // default delimeter
    String deli = "\\n|,";
   
    if(numbers.length() > 0){
      char charAtInd0 = numbers.charAt(0);
      // modify delimeter if required.
      if(charAtInd0 != '-' && Character.getNumericValue(charAtInd0) < 0){
        String ar[] = numbers.split("\n");

        // mulitple delimeter handling
        if(charAtInd0 == '['){
          deli = "";
          String delimSet[] = ar[0].substring(1, ar[0].length()-1).split("\\]\\[");
          for(int i = 0; i< delimSet.length; i++)
            deli += delimSet[i]+"|";
          
          deli = deli.substring(0,deli.length()-1);
        } else 
          deli = ar[0];
        numbers = ar[1];
      }
      String arr[] = numbers.split(deli);
      int len = arr.length;
      try{
        // check if string format is invalid (e.g, “1,\n”)
        if(Character.getNumericValue(numbers.charAt(numbers.length()-1)) < 0) throw new NumberFormatException("invalid numbers, please pass a valid string");
        if(len == 1){
          sum = Integer.parseInt(arr[0]);
          if(sum < 1001) sum = 0;
          if(sum < 0) throw new NumberFormatException("Negatives not allowed & you passed "+sum);
        } else {
          String ngNumber = "";
          for(int i = 0; i < len; i++){
            int num = Integer.parseInt(arr[i]);
            if(num < 0){
              ngNumber += arr[i] + " ";
              continue;
            }
            if(num < 1001)
              sum += num;
          }
          if(ngNumber.length() > 0) throw new NumberFormatException("Negatives not allowed & you passed "+ngNumber);
        }
      } catch(NumberFormatException e){
        sum = -1;
        e.printStackTrace();
      }
    }
    return sum;
  }

  public static void main(String argv[]){
    Test t = new Test();
    System.out.println("TestCase 1(\"-1\"): "+t.Add("-1"));
    System.out.println("TestCase 2(\"1\n3,4\n9\"): "+t.Add("1\n3,4\n9"));
    System.out.println("TestCase 3(\"1\n\n3,4\n9\"): "+t.Add("1\n\n3,4\n9"));
    System.out.println("TestCase 4(\"1,9\n0\n\"): "+t.Add("1,9\n0\n"));
    System.out.println("TestCase 5(\"::\n1::9::0::\"): "+t.Add("::\n1::9::0::"));
    System.out.println("TestCase 6(\"]\n1]9]0\"): "+t.Add("]\n1]9]0"));
    System.out.println("TestCase 7(\"@\n1@9@0\"): "+t.Add("@\n1@9@0"));
    System.out.println("TestCase 8(\"@\n-1@-9@-0\"): "+t.Add("@\n-1@-9@-0"));
    System.out.println("TestCase 9(\"[@][!]\n1!9@-0\"): "+t.Add("[@][!]\n1!9@-0"));
    System.out.println("TestCase 10(\"[@!]\n1!@9\"): "+t.Add("[@!]\n1@!9"));
    System.out.println("TestCase 11(\"1000\n9\"): "+t.Add("1000\n9"));
    System.out.println("TestCase 12(\"1,3,4\"): "+t.Add("1,3,4") );
  }
}

