package hello.hellospring.domain;

public class Member {
    private Long id; //시스템이 저장하는 아이디, 데이터 구분을 위해
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
