package lk.ijse.cmjd108.LibMgmt2025.service.secure;

import lk.ijse.cmjd108.LibMgmt2025.dto.secure.JWTAuthResponse;
import lk.ijse.cmjd108.LibMgmt2025.dto.secure.SignIn;
import lk.ijse.cmjd108.LibMgmt2025.dto.secure.UserDTO;

public interface AuthService {
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse signUp(UserDTO userDTO);
}
