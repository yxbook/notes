package com.iamlook.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

  @NotNull(message = "username can not be null!")
  @NotEmpty(message = "username can't be empty!")
  private String username;

  @NotNull(message = "password can not be null!")
  @NotEmpty(message = "password can't be empty!")
  private String password;
}
