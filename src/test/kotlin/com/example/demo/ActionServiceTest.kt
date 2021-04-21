package com.example.demo

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Import
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [ActionServiceImpl::class])
@Import(TestSecurityConfig::class)
class ActionServiceTest {

  @Autowired
  lateinit var actionService: ActionService

  @Test
  fun save() {
    val action = Action(
      userId = 1
    )
    runBlocking {
      actionService.save(action)
    }
  }
}
