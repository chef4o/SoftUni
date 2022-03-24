function solve(){
    class Person {
        constructor(name, email) {
            this.name = name,
            this.email = email
        }
        toString () {
            return `${this.constructor.name} (name: ${this.name}, email: ${this.email})`;
        }
    }
    
    function extend(classDefinition) {
        classDefinition.prototype.spices = 'Human';
        classDefinition.prototype.toSpicesString = function() {
            return `I am a ${this.spices}. ${this.toString()}`;
        }
    }
}
