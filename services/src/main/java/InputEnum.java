import lombok.Getter;

@Getter
public enum InputEnum {

    TEST("Input test");

    private String input;

    InputEnum(String input){
        this.input = input;
    }
}
