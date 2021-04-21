package com.example.demo

import org.springframework.security.access.prepost.PreAuthorize

interface ActionService {
  // fails
  @PreAuthorize("#action.getUserId() == 1")
  // works
  // @PreAuthorize("#action[0].getUserId() == 1")
  suspend fun save(action: Action)
}
