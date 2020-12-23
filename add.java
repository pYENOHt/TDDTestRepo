class Test{

  int Add(String numbers){
    int sum = 0;
    String deli = "\\n|,";
    if(numbers.length() > 0){
      // check if first character is number then proced else change delimeter value
      if(Character.getNumericValue(numbers.charAt(0)) < 0){
        String ar[] = numbers.split("\n");
        deli = ar[0];
        numbers = ar[1];
      }
      String arr[] = numbers.split(deli);
      int len = arr.length;
      try{
        if(Character.getNumericValue(numbers.charAt(numbers.length()-1)) < 0) throw new NumberFormatException();
        if(len == 1){
        sum = Integer.parseInt(arr[0]);
        } else {
          for(int i = 0; i < len; i++)
            sum += Integer.parseInt(arr[i]);
        }
      } catch(NumberFormatException e){
        sum = -1;
        System.out.println("invalid numbers, please pass a valid string");
      }
    }
    return sum;
  }

  public static void main(String argv[]){
    Test t = new Test();
    System.out.println("TestCase 1(\"\"): "+t.Add(""));
    System.out.println("TestCase 2(\"1\n3,4\n9\"): "+t.Add("1\n3,4\n9"));
    System.out.println("TestCase 3(\"1\n\n3,4\n9\"): "+t.Add("1\n\n3,4\n9"));
    System.out.println("TestCase 4(\"1,9\n0\n\"): "+t.Add("1,9\n0\n"));
    System.out.println("TestCase 5(\"::\n1::9::0::\"): "+t.Add("::\n1::9::0::"));
    System.out.println("TestCase 6(\"]\n1]9]0\"): "+t.Add("]\n1]9]0"));
    System.out.println("TestCase 7(\"@\n1@9@0\"): "+t.Add("@\n1@9@0"));
  }
}
