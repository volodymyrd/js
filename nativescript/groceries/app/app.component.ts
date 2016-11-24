import { Component } from "@angular/core";

@Component({
    selector: "my-app",
    templateUrl: "app.component.html",
    styleUrls: ["pages/login/login-common.css", "pages/login/login.css"]
})
export class AppComponent {
    email = "nativescriptrocks@telerik.com";
    isLoggingIn = true;

    submit() {
        alert("You’re using: " + this.email);
    }
    toggleDisplay() {
        this.isLoggingIn = !this.isLoggingIn;
    }
}