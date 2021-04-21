package com.example.demo

import org.springframework.stereotype.Service

@Service
class ActionServiceImpl : ActionService {
  override suspend fun save(action: Action) {
    println("save")
  }
}
