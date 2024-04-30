package pckg1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PEOPLE {
    private long id;
    private String last_name;
    private String first_name;
    private String second_name;
    private char sex;
    private String birthday;

}
