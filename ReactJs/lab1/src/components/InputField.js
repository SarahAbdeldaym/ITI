import { Component } from "react";


export default class InputField extends Component{
    constructor(){
        super();
        this.state={
            input: "",
        }
    }


    reset = () =>{
        this.setState({ input:"" })
    }

    render() {
        return (
            <div align="center">
                <input
                    type="text"
                    style={ {background:'white'} }
                    value={this.state.input}
                    onChange={(e) => {
                        this.setState({ input: e.target.value })
                    }}
                />
               
                {this.state.input}
       
                <input
                    style={ {background:'yellow'} }
                    
                    type="button"
                    value="Reset"
                    onClick={this.reset}
                />
            </div>
        )
    }
}