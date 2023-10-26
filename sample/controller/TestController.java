package jar.project.timelapsev0.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  private static final Logger logger = LogManager.getLogger(TestController.class);
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('gggg') or hasRole('rrrrr') or hasRole('aaaaa')")
  public String userAccess() {
    logger.info("test logger");
    return "User Content.";
  }

  @GetMapping("/mod")
  @PreAuthorize("hasRole('rrrrrr')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('aaaaaa')")
  public String adminAccess() {
    return "Admin Board.";
  }
}
