package lk.ijse.cmjd108.LibMgmt2025.dto.secure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignIn implements Serializable {
    private String email;
    private String password;
}
