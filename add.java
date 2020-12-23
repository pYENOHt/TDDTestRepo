class Test{

  int Add(String numbers){
    int sum = 0;
    if(numbers.length() > 0){
      String arr[] = numbers.split(",");
      int len = arr.length;
      try{
        if(len == 1){
        sum = Integer.parseInt(arr[0]);
        } else {
          for(int i = 0; i < len; i++){
            sum += Integer.parseInt(arr[i]);
          }
        }
      } catch(NumberFormatException e){
        sum = 0;
        e.printStackTrace();
      }
    }
    return sum;
  }

  public static void main(String argv[]){
    Test t = new Test();
    System.out.println("TestCase 1(\"\") : "+t.Add(""));
    System.out.println("TestCase 2(\"1\") : "+t.Add("1"));
    System.out.println("TestCase 3(\"1,3\") : "+t.Add("1,3"));
    System.out.println("TestCase 4(\"1,m\") : "+t.Add("1,m"));
  }
}
