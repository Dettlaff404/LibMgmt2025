package lk.ijse.cmjd108.LibMgmt2025.service.impl.secure;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd108.LibMgmt2025.dto.secure.JWTAuthResponse;
import lk.ijse.cmjd108.LibMgmt2025.dto.secure.SignIn;
import lk.ijse.cmjd108.LibMgmt2025.dto.secure.UserDTO;
import lk.ijse.cmjd108.LibMgmt2025.service.secure.AuthService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthServiceIMPL implements AuthService {
    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        return null;
    }

    @Override
    public JWTAuthResponse signUp(UserDTO userDTO) {
        return null;
    }
}
