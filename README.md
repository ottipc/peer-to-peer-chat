# Prerequisites

    Java Development Kit (JDK): Ensure you have Java installed on your system. This program is compatible with OpenJDK or any standard Java JDK. The version should be Java 8 or newer.
    Command Line Tool: You'll need a command line tool like Terminal on macOS/Linux or Command Prompt/Powershell on Windows.

## Step 1: Prepare the Java File

    Save the provided Java code into a file named SqlChat.java. This file name is important because the public class in our code is named SqlChat.

## Step 2: Compile the Java Program

    Open your command line tool.
    Navigate to the directory where SqlChat.java is saved.
    Compile the Java program by running:

    bash

    javac SqlChat.java

    This command should create a SqlChat.class file in the same directory, which is the bytecode version of your program.

## Step 3: Start the Server Instance

    In the same directory, start the server instance of your chat application by running:

    bash

    java SqlChat

    The server will display its IP address and listening port, something like Server started. Connect on 192.168.1.2:12345. Note this information, as you'll need it to start the client.

## Step 4: Start the Client Instance

    Open a new terminal window or tab.
    Navigate to the same directory where your SqlChat.class file is located.
    Start the client instance by running the command with the server's IP address and port. For example, if your server displayed 192.168.1.2:12345, you would run:

    bash

    java SqlChat --other_instance 192.168.1.2:12345

    The client will attempt to connect to the server using the provided IP address and port.

## Step 5: Chatting

    Once both the server and client instances are running and connected, you can start typing messages in either terminal.
    Press Enter to send the message. The message will appear in the other terminal window.
    Both parties can continue to send messages back and forth.

## Step 6: Exiting the Chat

    To exit the chat, type EXIT (in all caps) and press Enter in either the server or client terminal.
    This command will terminate the chat application.

### Troubleshooting

    Firewall Issues: If you are unable to connect, ensure that your firewall settings allow TCP connections on the port used (default is 12345).
    Network Issues: Ensure both the server and client are on the same network if you're using local network IP addresses.
    Java Version: Confirm that you are using an appropriate version of Java (Java 8 or newer).

That's it! You should now be able to use the chat application for simple text-based communication between two terminals.# peer-to-peer-chat