package helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("renderer")   // This is the same as @Component(value="renderer")
public class StandardOutMessageRenderer implements MessageRenderer {
  private MessageProvider messageProvider = null;

  @Autowired
  public StandardOutMessageRenderer(MessageProvider messageProvider) {
    this.messageProvider = messageProvider;
  }

  @Override
  public void render() {
    System.out.println(messageProvider.getMessage());
  }
}