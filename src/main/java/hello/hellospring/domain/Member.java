package hello.hellospring.domain;

public class Member { //회원객체
    //필드: 객체의 데이터가 저장되는 곳
    private Long id; //시스템이 저장하는 아이디, 데이터 구분을 위해
    private String name;

    //메소드: 객체의 동작에 해당하며 클래스의 다양한 동작을 구성
    //getter: 외부에서 객체의 데이터를 읽을 때. public 필드리턴타입 get+필드이름 { return 필드값 }
    //setter: 데이터는 외부에서 접근하지 않도록 막고, 메소드는 공개해서 외부에서 메소드를 통해 데이터에 접근하도록 유도. public void set+필드이름(필드타입){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        //this.name의 name은 위의 필드값의 name을 의미
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
