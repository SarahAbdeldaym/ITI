class Calculator
  def calculate
    puts "first number : "
    number1 = gets.chomp
    puts "operator : "
    operator = gets.chomp
    puts "second number: "
    number2 = gets.chomp

    number1 = number1.to_f
    number2 = number2.to_f

    case operator
    when "+"
      puts "#{number1} + #{number2} = #{number1 + number2}"
    when "-"
      puts "#{number1} - #{number2} = #{number1 - number2}"
    when "*"
      puts "#{number1} * #{number2} = #{number1 * number2}"
    when "/"
      if number2 == 0 or number1 == 0
        puts "can't divide by zero!!! "
      else
        div = number1.div(number2)
        puts "#{number1} / #{number2} = #{div.to_f}"
      end

    else
      puts "invalid operator"
    end
  end
end

calculator = Calculator.new
puts calculator.calculate