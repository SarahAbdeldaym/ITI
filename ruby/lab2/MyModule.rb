module MyModule
  require 'date'

  class Person
    attr_accessor :firstName, :lastName, :birthDate
    @firstName
    @lastName
    @birthDate

    def initialize
      @firstName = ""
      @lastName = ""
      @birthDate = ""
    end

    def get_person_data
      puts "Enter Your First Name : "
      @firstName = gets.chomp

      puts "Enter Your Last Name : "
      @lastName = gets.chomp

      puts "Enter Your Birth Date (YYYY/MM/DD): "
      @birthDate = (Date.today - Date.parse(gets.chomp)).to_i
    end

    def print_age
      puts "Welcome #{firstName} #{lastName}"
      puts " your age in years : #{@birthDate / 365}"
      puts " your age in Months : #{@birthDate / 12}"
      puts " your age in Days : #{@birthDate}"
    end
  end
end

person = MyModule::Person.new
person.get_person_data
person.print_age