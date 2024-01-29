package com.exam.aiWork;

import java.util.List;

public class ChatResponse {

    private String id;
    private String object;
    private long created;
    private List<Choice> choices;
    private Usage usage;
//    
//    @Override
//    public String toString() {
//        return "ChatResponse{" +
//                "id='" + id + '\'' +
//                ", object='" + object + '\'' +
//                ", created=" + created +
//                ", choices=" + choices +
//                ", usage=" + usage +
//                '}';
//    }

    @Override
    public String toString() {
        return "ChatResponse{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created=" + created +
                ", choices=" + choices.toString() +
                ", usage=" + usage.toString() +
                '}';
    }


    // constructors, getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public static class Choice {

        private int index;
        private Message message;
        private String finish_reason;

        
        @Override
		public String toString() {
			return "Choice [index=" + index + ", message=" + message.toString() + ", finish_reason=" + finish_reason + "]";
		}

		// Default constructor with no arguments
        public Choice() {
        }

        public Choice(int index, Message message, String finish_reason) {
            this.index = index;
            this.message = message;
            this.finish_reason = finish_reason;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

        public String getFinish_reason() {
            return finish_reason;
        }

        public void setFinish_reason(String finish_reason) {
            this.finish_reason = finish_reason;
        }

        // Additional constructors, getters, and setters
    }

    public static class Usage {

        private int prompt_tokens;
        private int completion_tokens;
        private int total_tokens;
        
        

        @Override
		public String toString() {
			return "Usage [prompt_tokens=" + prompt_tokens + ", completion_tokens=" + completion_tokens
					+ ", total_tokens=" + total_tokens + "]";
		}

		// Default constructor with no arguments
        public Usage() {
        }

        public Usage(int prompt_tokens, int completion_tokens, int total_tokens) {
            this.prompt_tokens = prompt_tokens;
            this.completion_tokens = completion_tokens;
            this.total_tokens = total_tokens;
        }

        public int getPrompt_tokens() {
            return prompt_tokens;
        }

        public void setPrompt_tokens(int prompt_tokens) {
            this.prompt_tokens = prompt_tokens;
        }

        public int getCompletion_tokens() {
            return completion_tokens;
        }

        public void setCompletion_tokens(int completion_tokens) {
            this.completion_tokens = completion_tokens;
        }

        public int getTotal_tokens() {
            return total_tokens;
        }

        public void setTotal_tokens(int total_tokens) {
            this.total_tokens = total_tokens;
        }

        // Additional constructors, getters, and setters
    }

    public static class Message {

        private String role;
        private String content;
        
        

        @Override
		public String toString() {
			return "Message [role=" + role + ", content=" + content + "]";
		}

		// Default constructor with no arguments
        public Message() {
        }

        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        // Additional constructors, getters, and setters
        
        
    }
}
