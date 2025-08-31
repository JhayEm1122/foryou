<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>I Like You Too</title>
  <style>
    :root{
      --bg1:#ffdee9;
      --bg2:#b5fffc;
      --card:#ffffffcc;
      --text:#1f2a37;
      --accent:#ff3b81;
    }

    * { box-sizing: border-box; }
    html, body {
      height: 100%;
      margin: 0;
      font-family: system-ui, -apple-system, Segoe UI, Roboto, Helvetica, Arial, "Apple Color Emoji", "Segoe UI Emoji";
      color: var(--text);
    }

    /* dreamy gradient background */
    body {
      background: radial-gradient(1200px 800px at 20% 20%, var(--bg1), transparent 60%),
                  radial-gradient(1000px 700px at 80% 70%, var(--bg2), transparent 60%),
                  linear-gradient(135deg, #fde1ff 0%, #e0f7ff 100%);
      display: grid;
      place-items: center;
      padding: 24px;
    }

    .card {
      width: min(680px, 92vw);
      background: var(--card);
      backdrop-filter: blur(8px);
      border-radius: 28px;
      box-shadow:
        0 10px 25px rgba(0,0,0,.08),
        inset 0 1px 0 rgba(255,255,255,.7);
      padding: 48px 36px;
      text-align: center;
      animation: float 6s ease-in-out infinite;
    }

    h1 {
      margin: 0 0 8px;
      font-size: clamp(36px, 6vw, 68px);
      line-height: 1.05;
      letter-spacing: 0.5px;
    }

    .heart {
      display: inline-block;
      transform: translateY(4px);
      animation: beat 1.4s ease-in-out infinite;
      margin-left: 8px;
    }

    p {
      margin: 10px 0 0;
      font-size: clamp(14px, 2.5vw, 18px);
      opacity: .75;
    }

    .pill {
      display: inline-block;
      margin-top: 22px;
      padding: 10px 16px;
      border-radius: 999px;
      background: rgba(255, 59, 129, .1);
      border: 1px solid rgba(255, 59, 129, .25);
      font-weight: 600;
      letter-spacing: .2px;
    }

    @keyframes float {
      0%, 100% { transform: translateY(0); }
      50% { transform: translateY(-8px); }
    }

    @keyframes beat {
      0%, 100% { transform: scale(1) translateY(4px); }
      25% { transform: scale(1.08) translateY(4px); }
      50% { transform: scale(0.98) translateY(4px); }
      75% { transform: scale(1.1) translateY(4px); }
    }

    /* a simple heart using CSS only */
    .heart::before,
    .heart::after {
      content: "";
      display: inline-block;
      width: 14px; height: 22px;
      background: var(--accent);
      border-radius: 14px 14px 0 0;
      transform: rotate(-45deg);
      transform-origin: bottom right;
      margin-right: -3px;
    }
    .heart::after {
      transform: rotate(45deg);
      transform-origin: bottom left;
      margin-right: 0;
      margin-left: -3px;
    }

    /* subtle focus ring for accessibility if tabbed */
    .card:focus-visible {
      outline: 3px solid #ffffff;
      outline-offset: 5px;
    }
  </style>
</head>
<body>
  <main class="card" tabindex="0" aria-label="I Like You Too message">
    <h1>I Like You Too <span class="heart" aria-hidden="true"></span></h1>
    <p>just wanted to make it official ✨</p>
    <div class="pill">you made me smile today</div>
  </main>
</body>
</html>
