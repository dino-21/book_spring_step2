
![49](https://github.com/dino-21/book_spring_step2/assets/80396471/45941a17-5e59-46a4-948f-dd0a14dd0d72)




1. 스프링 프로젝트 복사해서 ex01로 만들기 

2. SampleController.java 파일 만들기
  @RequestMapping("/sample")
http://localhost:8282/sample 요청

3.  @RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})
post 확인  - form 태그를 대신 postman으로 테스트함

4.  @GetMapping("/basicOnlyGet")
 http://localhost:8282/sample/basicOnlyGet

5.  @PostMapping("basicOnlyPost")
포트스맨 post로 확인

6.  파라미터의 수집과 변환 
- Controller가 파라미터를 수집, 파라미터 타입에 따라 자동변환
- @RequestParam : 파라미터로 사용된 변수의 이름과 전달되는 파라미터의 값이 다른 경우
- 객체 리스트 : SampleDTO의 여러개 전달 받아서 처리
SampleDTO.java 만들기
@Data
public class SampleDTO {
   private String name;
   private int age;
}

7.   
@GetMapping("/ex01")
  public String ex01(SampleDTO sampleDTO) {
	  log.info("ex01 : " + sampleDTO);
	  return "ex01";
  }
http://localhost:8282/sample/ex01?name=dino&age=20

8. ex01.jsp파일만들기
  return "ex01";

9.   //변수명이 같으면 @RequestParam("name") 생략
 @GetMapping("/ex02")
 public String ex02(String name, int age) {
	log.info("name : " + name);
	log.info("age : " + age);
	return "ex02";
  }
10. 
@GetMapping("/ex03")
public String ex03(@RequestParam("name") String name, @RequestParam("age") int age) 
	log.info("name : " + name);
	log.info("age : " + age);
	return "ex03";
   }
}





11. 
@GetMapping("/ex04")
  public String ex04(@RequestParam("name") String n, @RequestParam("age") int a) {	
      log.info("name : " + n);
      log.info("age : " + a);
      return "ex04";
   }
}


12. Model이라는 데이터 전달자
Model객체는 JSP에 컨트롤러에서 생성된 데이터를 담아서 전달
 @GetMapping("/ex008")
   public String ex008(Model model, SampleDTO dto, int page) {
       // 모델에 값 추가
        model.addAttribute("dto", dto);   
        model.addAttribute("page", page);
        return "/sample/ex008";
 }		
}

ex008.jsp 만들기
 dto: ${dto}
 page: ${page}


13.  @InitBinder 타입변환 – 날짜
TodoDTO.java 
@Data
public class TodoDTO {
  private String title;
  private Date dueDate;
}

initBinder 함수사용
public void initBinder(WebDataBinder binder) {생략...}
http://localhost:8282/sample/ex007?title=dino&dueDate=2023-12-21




14.   
@Data
public class TodoDTO {
  private String title;
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date dueDate;
}

http://localhost:8282/sample/ex007?title=dino&Date=2023-12-21

