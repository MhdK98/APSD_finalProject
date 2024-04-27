package miu.edu.cs489.packagetracker.service;


import miu.edu.cs489.packagetracker.dto.LogInResponseDTO;
import miu.edu.cs489.packagetracker.dto.LoginRequestDTO;

public interface AuthService {

    LogInResponseDTO login(LoginRequestDTO loginRequest) throws Exception;
//    LogInResponseDTO refreshToken(RefreshTokenRequestDTO refreshTokenRequest);
}
