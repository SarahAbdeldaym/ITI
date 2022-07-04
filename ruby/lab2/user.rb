class User
    @@default = "user"
  
    def initialize(name = "default name")
      @name = name
    end
  
    def get_name
      @nsqlame
    end
  
    def set_name=(name)
      @name = name
    end
  
    def get_default
      @@default
    end
  
    def change_default=(defaultName)
      @@default = defaultName
    end
  end
  
  user = User.new "sarah"
  puts "Name variable in the created instance is : #{user.get_name}"
  
  user.set_name = "dina"
  puts "Name variable after updating: #{user.get_name}"
  
  user.change_default = "user_name"
  puts "Name variable default value is : #{user.get_default}"
