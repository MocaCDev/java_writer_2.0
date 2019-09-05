package use_type.use_type;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import use_type_setup.use_type_setup.use_type_setup;
import write.write.write;

public class use_type extends use_type_setup {
  // Globabl variables
  private String type;
  private Scanner get_line = new Scanner(System.in);
  private ArrayList<String> return_data;
  private write w_f = new write();

  // Overriding the function, or calls
  @Override
  public String get_type_to_return(String type_to_return) {
    this.type = type_to_return;
    return this.type;
  }
  @Override
  public void use_type_(ArrayList<String> data) throws Exception {
    ArrayList<String> return_data = new ArrayList<String>();
    if(this.type.equals("port")) {
      System.out.print("Port Name: ");
      String get_port_type = this.get_line.nextLine();
      data.add("port_name::-->"+get_port_type);
      this.return_data = data;
    } else if(this.type.equals("connect")) {
      System.out.print("File Name: ");
      String file_dir = get_line.nextLine();
      File con_to_dir = new File(file_dir);
      if(con_to_dir.canRead()) {
        System.out.println("\n\nConnection Made\nStatus 202");
      } else {
        throw new Exception("Error whilst connecting");
      }
      w_f.get_data(file_dir, con_to_dir.canRead());
      data.add("connect_to_file::-->"+con_to_dir);
      this.return_data = data;
    } else if(this.type.equals("reg")) {
      System.out.println(this.type);
    } else {
      throw new Exception("Type could not be confirmed");
    }
  }
  @Override
  public String return_all_vals() {
    // Taking this.return_data from ArrayList to a simple string
    // So we can return String

    for(int i = 0; i < this.return_data.size()-1; i++) {
      String s = this.return_data.get(i)+", "+this.return_data.get(i+1);
      return s;
    }
    return this.type;
  }
}
